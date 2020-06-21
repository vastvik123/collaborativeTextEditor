const dotenv = require('dotenv');
const path = require('path');
const http = require('http');
const express = require('express');
const socketio = require('socket.io');
const {userJoin, userLeaves, getUsers, getCurrentUser, getShareStrings} = require('./users.js');

dotenv.config();

const app = express();
const server = http.createServer(app);
const io = socketio(server);
const port = process.env.PORT || 3000;

io.on('connection', socket => {

    socket.on('shareString', msg => {
        
        const user = userJoin(socket.id, msg.shareString);
        socket.join(msg.shareString);
        socket.emit('message', {msg:"Welcome!"});
        console.log(msg.shareString);
    });

    socket.on('sendStrings', msg => {
        var allStrings = new Set();
        allStrings = getShareStrings();
        jsonArray = JSON.stringify(Array.from(allStrings));
        console.log(jsonArray);
        socket.emit('allStrings', {string: jsonArray});
    });
    
    socket.on('data', data =>{
        const user = getCurrentUser(socket.id);
        socket.broadcast.to(user.shareString).emit('data', data);
        console.log(data);
        console.log("data sent!");
    });

    socket.on('disconnect', () => {

        userLeaves(socket.id);
        console.log(`A client disconnected: ${socket.id}`);
    });

});

server.listen(port, () => console.log(`server running on port ${port}`));
