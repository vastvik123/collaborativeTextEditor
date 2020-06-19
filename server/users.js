const users = [];

//user joins the server
function userJoin(id, shareString){
    const user = {id, shareString};
    users.push(user);
    return user;
}

//user leaves
function userLeaves(id){
    const index = users.findIndex(user => user.id === id);
    if(index !== -1){
        return users.splice(index,1)[0];
    }
}

//Get users sharing a same string
function getUsers(shareString){
    return users.filter(user => user.shareString === shareString);
}

//Get shareString of current User
function getCurrentUser(id){
    const index = users.findIndex(user => user.id === id);
    if(index !== -1)
    return users[index];
}

//Get all shareStrings
function getShareStrings(){
    var result = new Set();
    for(i = 0; i<users.length; i++){
        result.add(users[i].shareString);
    }
    return result;
}

module.exports = {
    userJoin,
    userLeaves,
    getUsers,
    getCurrentUser,
    getShareStrings
}
