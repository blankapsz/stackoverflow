import {useEffect, useState} from "react";
import { Link } from "react-router-dom";

const Questions = () => {
    const [displayQuestions, setDisplayQuestions] = useState([]);
    const [sortedQuestions, setSortedQuestion] = useState([]);
    const [showSorted, setShowSorted] = useState(false);

    useEffect(() => {
            fetch("/api/question/all")
                .then((response) => {
                    return response.json();
                })
                .then((response) => {
                    setDisplayQuestions(response);
                    console.log(response);
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        []);
    const handleDelete = (id) => {
        console.log("handledelete")
        fetch(`/api/question/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                setDisplayQuestions(prevQuestions => prevQuestions.filter(question => question.id !== id));
            })
            .catch(error => console.error(error));
    }

    const handleSort = (criteria) => {
        fetch(`/api/question/sorted/${criteria}`)
            .then((response) => {
                return response.json();
            })
            .then((response) => {
                setDisplayQuestions([])
                setSortedQuestion(response);
                setShowSorted(!showSorted);
            })
            .catch((error) => {
                console.error(error);
            });
    };

    return (
        <div className="questions">
            <button onClick={() => handleSort("title")}>Sort by title</button>
            <button onClick={() => handleSort("date")}>Latest Questions</button>
            <button onClick={() => handleSort("answerCount")}>Hottest Topics</button>
            {showSorted ? (
                <div>
                    {sortedQuestions && sortedQuestions.map((question, index) => (
                        <div key={index}>
                            <h3>{question.title}</h3>
                            <h5>{question.description}</h5>
                            <h5>Answers: {question.answerCount}</h5>
                            <h5>Created: {question.created}</h5>
                            <button onClick={() => handleDelete(question.id)}>Delete</button>
                            <Link to={`/answer/question/${question.id}`} >
                                <button>Show answers</button>
                            </Link>
                        </div>
                    ))}
                </div>
            ) : (
                <div>
                    {displayQuestions && displayQuestions.map((question, index) => (
                        <div key={index}>
                            <h3>{question.title}</h3>
                            <h5>{question.description}</h5>
                            <button onClick={() => handleDelete(question.id)}>Delete</button>
                            <Link to={`/answer/question/${question.id}`} >
                            <button>Show answers</button>
                            </Link>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Questions;