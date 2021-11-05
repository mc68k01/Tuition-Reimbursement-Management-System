
function saveUserName(userName){
    localStorage.setItem('username', userName);
}

function retrieveUserName(username){
    localStorage.getItem(username);
}