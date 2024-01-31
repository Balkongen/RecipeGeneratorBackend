var scrollBtn;

function checkBtn() {
   scrollBtn = document.getElementById("scrollBtn");
   scrollBtn.addEventListener("click",removeBtn);
}
window.addEventListener("load",checkBtn);

function removeBtn() {
    scrollBtn.style.display = "none";
}