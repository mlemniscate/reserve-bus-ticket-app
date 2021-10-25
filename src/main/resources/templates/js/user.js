function loadUser() {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let user = JSON.parse(this.responseText);
      document.getElementById('userFirstLastName').innerHTML =
        user.firstName + ' ' + user.lastName;
    }
  };
  xhttp.open(
    'GET',
    `http://localhost:8080/user/user?username=${sessionStorage.getItem(
      'username'
    )}`
  );
  xhttp.send();
}
loadUser();

document.querySelector('#logout').addEventListener('click', (event) => {
  if (confirm('آیا می خواهید از حساب خود خارج شوید؟')) {
    sessionStorage.clear();
    window.location.href = 'index.html';
  }
});

// date picker
let dateInput = document.getElementById('date');
jalaliDatepicker.startWatch();
dateInput.addEventListener('focus', (event) => {
  jalaliDatepicker.show(dateInput);
});

// search result
// function searchTravels() {
//   const xhttp = new XMLHttpRequest();
//   xhttp.onreadystatechange = function () {
//     if (this.readyState == 4 && this.status == 200) {
//       let user = JSON.parse(this.responseText);
//       document.getElementById('userFirstLastName').innerHTML =
//         user.firstName + ' ' + user.lastName;
//     }
//   };
//   xhttp.open(
//     'GET',
//     `http://localhost:8080/user/user?username=${sessionStorage.getItem(
//       'username'
//     )}`
//   );
//   xhttp.send();
// }
// searchTravels();
