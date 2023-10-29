
// To fetch the Home page HTML
document.addEventListener("DOMContentLoaded", async function () {

 try {
             const response = await fetch("/");
             if (!response.ok) {
                 throw new Error('Network response was not ok');
             }
             const data = await response.text(); // Parse the response body as JSON
             document.getElementById("container").textContent = data;
         } catch (error) {
             console.error('Error:', error);
             throw error; // Optionally rethrow the error for higher-level error handling
         }
});

