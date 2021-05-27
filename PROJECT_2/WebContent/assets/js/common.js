/**
 * 
 */
/*function  drop_down() {
	let list_btn = document.querySelectorAll(".dropdown-btn");
    
   for (let i = 0; i < list_btn.length; ++i) {
   		list_btn[i].addEventListener("click", function() {
        	this.classList.toggle("active");
            
            let content = this.nextElementSibling;
            if (window.getComputedStyle(content, null).display === "none") {
				content.style.display = "block";
			} else {
            	content.style.display = "none";
            }
        });
   }
}

window.onload = function() {drop_down()};*/

$(function() {
	$(".dropdown-btn").on("click", function() {
		$(this).toggleClass("active");
		$(this).next().toggle();
	});
});
