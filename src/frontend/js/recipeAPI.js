var clickDiv;
const URL = "http://localhost:8080/getRandRecipe"


function init() {
    clickDiv = document.getElementById("topCont");
    clickDiv.addEventListener("click", getRecipe);
}
window.addEventListener("load", init);

function getRecipe() {
    
    fetch(URL).then(res => {
        return res.json()
    }).then(data => {
        clear()
        let title = document.getElementById("recipeTitle");
        let instrDiv = document.getElementById("instructionsP");
        showBotCont()
        title.innerHTML = data.name
        instrDiv.innerHTML = data.instructions
        printIngredients(data)
        // console.log(data)
    })
}

function clear() {
    const list = document.getElementById("ingList");
    
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function printIngredients(current) {
    let list = document.getElementById("ingList");

    for (let i of current.ingredients) {
        let li = document.createElement("li");
        list.appendChild(li);
        li.innerHTML = i;
    }
}

function showBotCont() {
    let div = document.getElementById("botCont");
    div.style.visibility = "visible";
}