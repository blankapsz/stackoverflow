import { useState } from "react";

const Registration = ({ showLogin, setShowLogin }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showRegistration, setShowRegistration] = useState(false);
    const [userExistsWarning, setUserExistsWarning] = useState(false);

    function handleSubmit(e) {
        e.preventDefault()
        const data = { username, password };
        fetch('/api/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(response => {
                if(response.ok){
                  console.log(response);
                  setPassword("")
                  setUsername("")
                  setUserExistsWarning(false)
                } else {
                  console.log(response);
                  setUserExistsWarning(true)
                  setPassword("")
                  setUsername("")
                }
            })
            .catch(err => {
                setUserExistsWarning(true)
                console.error("Registration error: ",err);
            });
    }

    const handleRegistrationButton = () => {
        setShowRegistration(!showRegistration);
        setShowLogin(!showLogin)
    };

    const handleUsernameChange = (e) => {
      setUsername(e.target.value);
      setUserExistsWarning(false)
    }

    const handlePasswordChange = (e) => {
      setPassword(e.target.value);
      setUserExistsWarning(false)
    }

    return (
        <div className="Registration">
            <button className="RegistrationButton" onClick={handleRegistrationButton}>
                {showRegistration ? 'Back' : 'Join'}
            </button>
            {showRegistration && (
                <form onSubmit={handleSubmit}>
                    <label>Name:
                        <input type="text" value={username} onChange={handleUsernameChange} />
                    </label>
                    <label>Password:
                        <input type="password" value={password} onChange={handlePasswordChange} />
                    </label>
                    <button type='submit'>Register</button>
                    {userExistsWarning ?
                      <h5 className={"warning"}>Username in use!</h5>
                      :
                      <h5></h5>
                    }
                </form>

            )}
        </div>
    );


}

export default Registration;
