import logo from './logo.svg';
import React from 'react';
import './App.css';
import { Simple, User, Profile, ProfileForm, UsersFromjson, ProfileList } from './components/Simple';


import { Routes,Link,Route } from 'react-router-dom';

// function SimpleList(){
//   let items = ["Apple","Grapes","Mango","Orange"];
//   return(<div className=''>
//     <h3>List of items:-</h3>
//     <p>{items.map((item,index)=><li key={index}><button className='btn btn-info col-3'>{item}</button></li>)}</p>
//   </div>)
// }

function App() {
  // let obj1 = {
  //   name:"virat kohli", dob : "1980-04-20", email:"virat.kohli@gmail.com"
  // };

  // let obj2 = {
  //   name:"sai jagadish nukala", dob : "2001-02-20", email:"saijagadish.nukala@gmail.com",
  //   imageURL:"https://th.bing.com/th/id/OIP.I7br8kpjF9KN9SJ-F67V0AAAAA?w=165&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"
  // };
  // return (
  //   <div><h2 className='alert alert-danger text-center'>This is the root component</h2>
  //   <Simple/>
  //   <User name="Alex" age="35"/>
  //   <Profile profile={obj1}></Profile>
  //   <Profile profile={obj2}></Profile>

  //   <SimpleList></SimpleList>
  //   <ProfileForm></ProfileForm>
  //   <UsersFromjson/>
  //   <ProfileList></ProfileList>
  //   </div>

  // );

  return (<div>
    <div>
      <Link to = "/register">Register Profile</Link>
      <Link to = "/list">List Profiles</Link>
      <Link to = "/delete">Delete Profiles</Link>
      <Link to = "/userJson">Users JSON</Link>
    </div>
    <hr/>
    <div>
      <Routes>
        <Route path='' element={<div>Show some default component</div>}></Route>
        <Route path='/register' element={<ProfileForm/>}> </Route>
        <Route path='/list' element={<ProfileList/>}></Route>
        <Route path='/userJson' element={<UsersFromjson/>}></Route>
      </Routes>
    </div>
  </div>)
}

export default App;
