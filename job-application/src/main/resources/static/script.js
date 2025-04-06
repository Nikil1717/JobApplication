document.getElementById("applicationForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const applicationData = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    position: document.getElementById("position").value,
  };

  fetch("/api/applications", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(applicationData)
  })
  .then(response => {
    if (response.ok) {
      alert("Application submitted successfully!");
    } else {
      alert("Error submitting application.");
    }
  });
});
