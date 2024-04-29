import { useState } from "react";
import axios from "axios";
import {useNavigate,useParams} from 'react-router-dom'

export function ProfileSuccess(){
    let {id} = useParams(); // URL will be 
    return(
    <div>
    <h3>Registered with an id: {id}</h3>
    </div>
    )
}

export function UsersFromjson() {
    let URL = 'https://jsonplaceholder.typicode.com/users';
    let [id, setId] = useState('');
    let handleClick = (e) => {
        axios.get(`${URL}/${id}`)
            .then(response => setUser(response.data))
            .catch(error => console.log(error));
    }
    let [user, setUser] = useState('');
    return (<div>
        <input type='number' name='id' onChange={e => setId(e.target.value)} placeholder="Enter the id" />
        <button className="btn btn-primary" onClick={handleClick}>Search</button>
        <div>
            <p>Hello {user.username}, your email: {user.email}</p>
        </div>
    </div>)
}

export function Simple() {
    let username = 'Sai Jagadish';
    return (<div><h3>Hello {username}</h3></div>)
}

export function User(props) {
    let name = props.name;
    let age = props.age;
    return (<div>
        <h2>User Component</h2>
        <h3>hello {name}, your age is {age}</h3>
    </div>)
}


//a component that takes complex object which will have name,dob,email,image
export function Profile(props) {
    let profile = props.profile;//<Profile profile = {object}/>
    //profile.name, profile.dob, profile.email, profile.imageURL

    return (<div>
        <img src={profile.imageURL} width="400" height="400" style={{ borderRadius: '50%' }} />
        <p>
            Name : {profile.name}
        </p>
        <p>
            Birthday : {profile.dob}
        </p>
        <p>
            Email : {profile.email}
        </p>
    </div>)

}

export function ProfileList() {
    let a=1;
    let [list, setList] = useState([]);
    let [profile, setProfile] = useState('');
    let URL = 'http://localhost:9091/api/profile/getProfiles';
    let handleClick = (e) => {
        axios.get(URL).then(response => setList(response.data));
    }
    return (<div>
        <h3> List of profiles </h3>
        <button onClick={handleClick}>Refresh</button>
        <table className="table">
            <thead>
                <tr>
                    <th>Pic</th><th>Profile ID</th><th>Name</th><th>Phone</th>
                    <th>Birthday</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>);
}

export function ProfileForm() {
    let [name, setName] = useState('');
    let [password, setPassword] = useState('');
    let [phone, setPhone] = useState('');
    let [dob, setDob] = useState('');
    let [id, setId] = useState('');
    let [profile, setProfile] = useState('');

    let URL = 'http://localhost:9091/api/profile';

    let registrationSubmit = (e) => {
        axios.post(URL, { "name": name, "dob": dob, "phone": phone })
            .then(response => setProfile(response.data))
            .catch(error => console.log(error));
        console.log(name, password, phone, dob);
    }

    return <div>
        <h2>Profile Registration</h2>
        {profile != '' || undefined ? (<h3 className = 'text-success'>Profile Registered with an id {profile.id}</h3>) : ''}
        <form onSubmit={registrationSubmit}>
            {profile != '' || undefined ? (<h3 className = 'text-success'>Profile Registered with an id {profile.id}</h3>) : ''}
            <input type='text' name='name' onChange={e => setName(e.target.value)} placeholder="Enter your name" /><br />
            <input type='password' name='password' onChange={e => setPassword(e.target.value)} placeholder="Enter the password" /><br />
            <input type='number' name='phone' onChange={e => setPhone(e.target.value)} placeholder="Enter your mobile number" /><br />
            <input type='date' name='dob' onChange={e => setDob(e.target.value)} placeholder="Enter your date of birth" /><br />
            <input type='submit' value='Register'></input>
        </form>
    </div>
}