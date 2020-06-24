function addOne(id, price) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var number = parseInt(document.getElementById(("q" + id)).innerHTML);
			document.getElementById(("q" + id)).innerHTML = number + 1;
			var productTotal = price*(number+1);
			document.getElementById(("p"+id)).innerHTML = productTotal.toFixed(2);
			var total = parseFloat(document.getElementById(("total")).innerHTML);
			total = total+price;
			document.getElementById(("total")).innerHTML = total.toFixed(2);
			$("#addButton").blur();
		}
	};
	xhttp.open("GET", "/BetterHome/cart/add-one?id=" + id, true);
	xhttp.send();
}

function deleteOne(id, price) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var number = parseInt(document.getElementById(("q" + id)).innerHTML);
			document.getElementById(("q" + id)).innerHTML = number - 1;
			var productTotal = price*(number-1);
			document.getElementById(("p"+id)).innerHTML = productTotal.toFixed(2);
			var total = parseFloat(document.getElementById(("total")).innerHTML);
			total = total-price;
			document.getElementById(("total")).innerHTML = total.toFixed(2);
			$("#subButton").blur();
		}
	};
	xhttp.open("GET", "/BetterHome/cart/delete-one?id=" + id, true);
	xhttp.send();
}

function deleteAll(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var productTotal = parseFloat(document.getElementById(("p"+id)).innerHTML);
			var total = parseFloat(document.getElementById(("total")).innerHTML);
			total = total - productTotal;
			document.getElementById(("total")).innerHTML = total.toFixed(2);
			document.getElementById(id).remove();
			console.log($("#table1").children().length);
			if($("#table1").children().length === 0) {
				window.location.replace("/BetterHome/cart");
			}
		}
	};
	xhttp.open("GET", "/BetterHome/cart/delete-all?id=" + id, true);
	xhttp.send();
}