(function ($) {

	"use strict";

	$('nav .dropdown').hover(function () {
		var $this = $(this);
		$this.addClass('show');
		$this.find('> a').attr('aria-expanded', true);
		$this.find('.dropdown-menu').addClass('show');
	}, function () {
		var $this = $(this);
		$this.removeClass('show');
		$this.find('> a').attr('aria-expanded', false);
		$this.find('.dropdown-menu').removeClass('show');
	});

})(jQuery);
$(document).ready(function () {

	$('#itemslider').carousel({
		interval: 3000
	});

	$('.carousel-showmanymoveone .item').each(function () {
		var itemToClone = $(this);

		for (var i = 1; i < 6; i++) {
			itemToClone = itemToClone.next();

			if (!itemToClone.length) {
				itemToClone = $(this).siblings(':first');
			}

			itemToClone.children(':first-child').clone()
				.addClass("cloneditem-" + (i))
				.appendTo($(this));
		}
	});
});

function Active(active) {
var div = document.getElementsByClassName('nav-item');

switch(active) {
  case 'home':
div[0].classList.add("active");

    break;
  case "newCar":
    div[1].classList.add("active");
    break;
  case "oldCar":
    div[2].classList.add("active");
    break;
  case "orderCar":
    div[3].classList.add("active");
     break;
  case "company":
     div[4].classList.add("active");
      break;
  case "showroom":
    div[5].classList.add("active");
      break;

  default:
    // code block
}


}
function loadDataDetail() {
	var element = document.getElementById("contain");
	var x = document.getElementById("contain").innerHTML;
	console.log(x);
	for (let index = 0; index < 9; index++) {
		element.innerHTML += x;
	}
}
     document.getElementById("imageCar").onchange = function () {
     var reader = new FileReader();

     reader.onload = function (e) {
         // get loaded data and render thumbnail.
         document.getElementById("image").src = e.target.result;
     };

     // read the image file as a data URL.
     reader.readAsDataURL(this.files[0]);

     };


function AddActive(){
var itemToClone = document.getElementsByClassName("item");
itemToClone[0].classList.add("active");
}
