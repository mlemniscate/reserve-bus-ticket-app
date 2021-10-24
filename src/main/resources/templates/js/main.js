if (sessionStorage.getItem('username')) window.location.href = 'user.html';

document.querySelector('#login-btn').addEventListener('click', (event) => {
  let loginUsername = document.querySelector('#loginUsername').value;
  let loginPassword = document.querySelector('#loginPassword').value;

  var data = `{
    "username": "${loginUsername}",
    "password": "${loginPassword}"
  }`;
  var url = 'http://localhost:8080/user/login';

  var xhr = new XMLHttpRequest();
  xhr.open('POST', url);

  xhr.setRequestHeader('Accept', 'application/json');
  xhr.setRequestHeader('Content-Type', 'application/json');

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      console.log(xhr.responseText);
      if (xhr.responseText == JSON.stringify('FAILURE'))
        alert('Your usernaem or password is wrong. please try again!');
      else {
        sessionStorage.setItem('username', JSON.parse(data).username);
        window.location.href = 'user.html';
      }
    }
  };
  xhr.send(data);
});
