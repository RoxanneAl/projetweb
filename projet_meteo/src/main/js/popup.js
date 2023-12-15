/*window.onclick = function(event) {
let person = prompt("Please enter your name", "","Password","");
let text;
if (person == null || person == "") {
text = "User cancelled the prompt.";
alert(text);
} else {
text = "Hello " + person + "! How are you today?";
alert(text);
}
let password = prompt("Please enter your password", "");
let text2;
}

function openForm2(){
let element = document.getElementById("login");
console.log("open");
}*/

let modalBtns = [...document.querySelectorAll(".button")];
console.log("bouton cliqué 1");
modalBtns.forEach(function (btn) {
    console.log("bouton cliqué 2");
    btn.onclick = function () {
        console.log("bouton cliqué 3");
        let modal = btn.getAttribute("data-modal");
        document.getElementById(modal).style.display = "block";
    };
});
let closeBtns = [...document.querySelectorAll(".close")];
console.log("bouton close 1");
closeBtns.forEach(function (btn) {
    console.log("bouton close 2");
    btn.onclick = function () {
        console.log("bouton close 3");
        let modal = btn.closest(".modal");
        modal.style.display = "none";
    };
});
window.onclick = function (event) {
    if (event.target.className === "modal") {
        event.target.style.display = "none";
    }
};