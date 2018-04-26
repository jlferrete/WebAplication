$(document).ready(function() {$(".nav").toggleClass("small");
$("#navMenu").click(function() {
  if ($(".nav").hasClass("small")) {
    $(".nav").removeClass("small");
  } else {
    $(".nav").addClass("small");
  }
});
});