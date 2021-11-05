
async function saveUserName(userName){
    localStorage.setItem('username', userName);
}

async function retrieveUserName(username){
    localStorage.getItem(username);
}