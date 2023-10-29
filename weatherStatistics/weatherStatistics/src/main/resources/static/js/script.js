
// To fetch the Home page HTML
document.addEventListener("DOMContentLoaded", async function () {

        let data;
        try {
             const response = await fetch("/");
             if (!response.ok) {
                  data = await response.json();
                  throw new Error(data.message);
             }
             data = await response.text(); // Parse the response body as JSON
             document.getElementById("container").textContent = data;
         } catch (error) {
             document.getElementById("errorMessage").innerHTML = error;// In the error.html
         }
});

