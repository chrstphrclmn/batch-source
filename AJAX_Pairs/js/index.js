console.log("YES");
window.onload = function() {
  this.document.getElementById("submit").addEventListener("click", process);
};

function process() {
  let API_KEY = "97cdbbc12323328006fe2d46fb751ba8";
  let food = document.getElementById("food").value;
  let url = `https://www.food2fork.com/api/search?key=${API_KEY}&q=${food}`;
  let xhr = new XMLHttpRequest();
  xhr.open("GET", url);
  xhr.responseType = "JSON";
  xhr.onload = function() {
    let status = xhr.status;
    if (status == 200) {
      let jsonObject = JSON.parse(xhr.response);
      console.log(jsonObject);

      let recipes = jsonObject.recipes;
      for (let i = 0; i < recipes.length; i++) {
        let html = `
        <div class="recipe">
            <div class="title">Title: ${jsonObject.recipes[i].title}</div>
            <div class="publisher">Publisher: ${jsonObject.recipes[i].publisher}</div>
            <img src="${jsonObject.recipes[i].image_url}" alt="food" height="42" width="42"> 
            <a target="_blank" href="${jsonObject.recipes[i].source_url}">Link to Recipe</a>
        </div>
        <br>
        `;
        console.log(jsonObject.ingredients);
        document.getElementById("results").innerHTML += html;
      }
    } else {
      console.log("Booo");
    }
  };
  xhr.send();
}

function getHTML() {}
//publisher
//f2f_url
//ingredients
//source_url
//recipe_id
//image_url
//social_rank
//publisher_url
//title
