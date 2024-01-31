const URL = "http://localhost:8080/addRecipe"

document.getElementById("recipeForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;
    const formData = new FormData(form);

    const ingredientsString = formData.get("ingredients");
    const tmp = ingredientsString.split(",");
    const ingredientsArray = tmp.map((str) => str.trim());

    // Convert the FormData object to a plain JavaScript object
    const formObject = {};
    formData.forEach((value, key) => {
        if (key === "ingredients") {
            formObject[key] = ingredientsArray;
        } else {
            formObject[key] = value;
        }
    });

    sendData(formObject);
});

function sendData(formData) {
    const jsonData = JSON.stringify(formData);
    
    fetch(URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json" 
        },
        body: jsonData 
    
    }).then(response => {
        
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        return response.json(); 

    }).then(data => {
        console.log("Response data:", data);
    }).catch(error => {
        console.error("Error:", error);
    });
}