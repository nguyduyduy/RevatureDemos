let user = localStorage.getItem('currentUser');


let myUser = JSON.stringify(user);
console.log(user)

console.log(myUser.email);


let greeting = document.getElementById('greeting');

greeting.innerHTML = `Welcome , ${myUser.first_name}`;


function logout(){
    localStorage.removeItem('currentUser');
    window.location.replace("index.html");
}