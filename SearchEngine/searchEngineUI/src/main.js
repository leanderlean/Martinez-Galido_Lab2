import "./style.css";
const searchBar = document.getElementById("searchBar");
const searchButton = document.getElementById("searchButton");
const suggestions = document.getElementById("suggestion");

searchBar.addEventListener("keyup", () => {
  const query = searchBar.value;

  fetch("search?q=" + query)
    .then((response) => response.json())
    .then((data) => {
      suggestions.innerHTML = "";

      data.forEach((item) => {
        suggestions.innerHTML += "<div>" + item + "</div>";
      });
    });
});
