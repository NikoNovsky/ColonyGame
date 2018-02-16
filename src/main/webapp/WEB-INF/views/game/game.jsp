<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	var upgrades = {
		campfire : 0,
		tent : 0,
		knife : 0
	}

	var storage = {
		wood : 0,
		stone : 0,
		food : 0,
		energy : 100
	}

	var efficiency = {
		food : 1,
		wood : 1,
		stone : 1,
		energy : 0
	}

	function increment(resource_name) {
		storage[resource_name] = storage[resource_name]
				+ efficiency[resource_name];
	}

	function looseEnergy() {
		storage['energy'] -= 10;
	}

	function update_resource(resource_name) {
		if (storage['energy'] >= 9) {

			increment(resource_name);
			looseEnergy();
			gui_update();
		} else {
			alert('Your energy is too low!');
		}
	}

	function gui_update() {
		$('#food_counter').html(storage.food);
		$('#wood_counter').html(storage.wood);
		$('#stone_counter').html(storage.stone);
		$('#energy_counter').html(storage.energy);
	}

	function persist() {
		var game_state = {
			user : user_id,
			efficiency : efficiency,
			storage : storage,
			upgrades : upgrades
		}

		var myHeaders = new Headers({
			'content-type' : 'application/json'
		})

		var myInit = {
			method : "POST",
			headers : myHeaders,
			mode : "cors",
			cache : "default",
			body : JSON.stringify(game_state)
		};

		fetch("${pageContext.request.contextPath}/savegame", myInit).then(
				function(response) {
					alert("Game saved!");
				})
	}

	function save() {
		storage['energy'] += 2 * $('#food_counter').html()
				+ efficiency['energy'];
		storage['food'] = 0;
		gui_update();
		persist();
	}

	function upgrade(name) {
		if (name == 'campfire') {
			if (storage['wood'] >= 2 && storage['stone'] >= 3) {
				upgrades.campfire += 1;
				storage['wood'] -= 2;
				storage['stone'] -= 3;
				efficiency.food += 1;
				$('.campfiretr').click(function() {
					$(this).toggleClass('hidden');
				})
				gui_update();
			} else {
				alert('Resources too low :(')
			}

		} else if (name == 'tent') {
			if (storage['wood'] >= 3) {
				upgrades.tent += 1;
				storage['wood'] -= 3;
				efficiency.energy += 10;
				$('.tenttr').click(function() {
					$(this).toggleClass('hidden');
				})
				gui_update();
			} else {
				alert('Resources too low :(')
			}

		} else if (name == 'knife') {
			if (storage['wood'] >= 1 && storage['stone'] >= 1) {
				upgrades.knife += 1;
				storage['wood'] -= 1;
				storage['stone'] -= 1;
				efficiency.food += 1;
				$('.knifetr').click(function() {
					$(this).toggleClass('hidden');
				})
				gui_update();
			} else {
				alert('Resources too low :(');
			}
		} else {
			gui_update();
		}
	}

	$('#campfiretr').click(function() {
		$(this).toggleClass('hidden');
	})

</script>
<meta charset="UTF-8">
<link rel="Stylesheet" type="text/css" href="../style.css" />
<title>Colony Game!</title>
</head>
<body>

	<table>
		<tr>
			<td>Energy:</td>
			<td id='energy_counter'>100</td>
		</tr>
	</table>

	<h1>RESOURCES</h1>

	<table>
		<tr>
			<td>Food:</td>
			<td id='food_counter'>0</td>
			<td> <img src='../food.png' height="42" width="42"/> </td>
		</tr>
		<tr>
			<td>Wood:</td>
			<td id='wood_counter'>0</td>
			<td> <img src='../wood.svg' height="42" width="42"/> </td>
		</tr>
		<tr>
			<td>Stone:</td>
			<td id='stone_counter'>0</td>
			<td> <img src='../stone.png' height="42" width="42"/> </td>
		</tr>
	</table>
	<h1>ACTIVITIES</h1>

	<table>
		<tr>
			<td><button class='ui-button' id='foodbutton'
					onclick="update_resource('food')">Gather food</button></td>
		</tr>

		<tr>
			<td><button class='ui-button' id='woodbutton'
					onclick="update_resource('wood')">Gather wood</button></td>
		</tr>

		<tr>
			<td><button class='ui-button' id='stonebutton'
					onclick="update_resource('stone')">Gather stone</button></td>
		</tr>
	</table>

	<h1>UPGRADES</h1>

	<table>
		<tr class='campfiretr'>
			<td><button class='ui-button' id='campfire'
					onclick="upgrade('campfire')">Camp fire</button></td>
			<td class='texttd'>You need 2 wood and 3 stone.</td>
			<td class='texttd'>You gather +1 food.</td>
		</tr>

		<tr class='tenttr'>
			<td><button class='ui-button' id='tent'
					onclick="upgrade('tent')">Tent</button></td>
			<td class='texttd'>You need 3 wood.</td>
			<td class='texttd'>You regenerate +10 energy more.</td>
		</tr>

		<tr class='knifetr'>
			<td><button class='ui-button' id='knife'
					onclick="upgrade('knife')">Knife</button></td>
			<td class='texttd'>You need 1 wood and 1 stone.</td>
			<td class='texttd'>You gather +1 food</td>
		</tr>
	</table>

	<button class='save-button' id='submit_button' onclick="save()">Save!</button>
</body>
</html>