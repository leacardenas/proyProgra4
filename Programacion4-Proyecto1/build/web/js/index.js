var sliderButton = document.querySelector(".sliderButton");
var open = 0;

sliderButton.addEventListener('click', function(e){
    var text = e.target.nextElementSibling;
    var loginText = e.target.parentElement;
    text.classList.toggle('show-hide');
    loginText.classList.toggle('expand');
    if(open === 0)
    {
        sliderButton.innerHTML = "<i class=\"fas fa-minus\"></i>";
        open = 1;
    }
    else
    {
        sliderButton.innerHTML = "<i class=\"fas fa-plus\"></i>";
        open = 0;
    }
});