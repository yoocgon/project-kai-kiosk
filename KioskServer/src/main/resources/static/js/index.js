 
async function fetchGetTest() {
  const response = await fetch('http://localhost:8080/kiosk/test');
  const content = await response.json();
  console.log("Log>>> (response) ", content); 
}

fetchGetTest();