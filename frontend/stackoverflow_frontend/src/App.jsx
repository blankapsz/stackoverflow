
import { useState } from 'react'
import './App.css'
import Questions from './Components/QuestionForm';
import Login from "./Components/Login.jsx";
import {Link} from "react-router-dom";

function App() {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('')

    function handleSubmit() {
        const data = { title, description };
        fetch('/api/question/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((response) => {
                console.log(response);
            })
            .catch((err) => {
                console.error(err);
            });
    }

    return (
        <div className="container">
            <Link to={"/users"} >
                <button className={"online"}>Who is online</button>
            </Link>
          <h1>STAKKOWERFLOV</h1>
            <Login />
            <form onSubmit={handleSubmit}>
                <label className={"titleLabel"}>Title:
                    <input className={"input"} type="text" value={title} onChange={e => setTitle(e.target.value)} />
                </label>
                <label className={"descriptionLabel"}>Question:
                    <input type='text' value={description} onChange={e => setDescription(e.target.value)}/>
                </label>
                <button type="submit">Send Question</button>
            </form>
            <Questions />
        </div>
    );
}

export default App;
