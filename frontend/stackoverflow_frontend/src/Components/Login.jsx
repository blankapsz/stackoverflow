import { useState, useEffect } from "react";
import Registration from "./Registration.jsx";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showLogin, setShowLogin] = useState(false);
    const [loggedUser, setLoggedUser] = useState(null);

    useEffect(() => {
        const storedUser = localStorage.getItem('loggedUser');
        console.log("storedUser", storedUser);
        if (storedUser !== null) {
            setLoggedUser(storedUser);
        } else {
            setLoggedUser(null)
        }
    }, [loggedUser]);

    function handleSubmit(e) {
        e.preventDefault();
        const data = { username, password };
        fetch('/api/user/authenticate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(response => {
                if (response === true) {
                    setLoggedUser(username);
                    localStorage.setItem('loggedUser', username);
                } else {
                    setLoggedUser("You should register first");
                }
                setShowLogin(false);
                setUsername('');
                setPassword('');
            })
            .catch(err => {
                console.error(err);
            });
    }

    const handleLoginButton = () => {
        setShowLogin(!showLogin);
    };

    const handleLogOutButton = () => {
        console.log("logout button")
        localStorage.removeItem('loggedUser');
        setShowLogin(!showLogin)
    };
    return (
        <div className="Login">
            {loggedUser ?
              <button className={"LoginButton"} onClick={handleLogOutButton}>
                  Log Out
              </button> :
              <button className="LoginButton" onClick={handleLoginButton}>
                  {loggedUser ? 'Back' : 'Log in'}
              </button>
            }
            {showLogin && (
              <form>
                  <label>Name:
                        <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
                    </label>
                    <label>Password:
                        <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                    </label>
                    <button onClick={handleSubmit}>Login</button>
                </form>
            )}
            <Registration
                showLogin={showLogin}
                setShowLogin={setShowLogin}
            />
        </div>
    );
}

export default Login;
