import express from "express";

const app = express();


app.get('/welcome', (req, res) => {
    res.send('welcome to docker and k8s');
})

app.listen(3000,()=> console.log('server is running using port no: 3000'))