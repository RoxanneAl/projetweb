window.onclick = function(event) {
let person = prompt("Please enter your name", "Harry Potter");
let text;
if (person == null || person == "") {
text = "User cancelled the prompt.";
} else {
text = "Hello " + person + "! How are you today?";
}
}

        function openForm2(){
             let element = document.getElementById("login");
             if (element.style.display =="block") {
                   document.getElementById("login").style.display = "none";
             }else ( element.style.display ="block");
            console.log("open");
        }
