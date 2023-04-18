import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Button } from '@mui/material'
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function App() {

  return (
    <div className="App">
        <div className="topnav">
            <a href="/home">
                <div id={"arrowBack"}>
                    <ArrowBackIcon/>
                </div>
            </a>
            <div id={"accountCircle"}>
                <AccountCircleIcon/>
            </div>
        </div>
        <div id={"btns"}>
            <Button id={"btn_custom"} variant="contained">Custom</Button>
            <Button id={"btn_push"} variant="contained">Push</Button>
            <Button id={"btn_pull"} variant="contained">Pull</Button>
            <Button id={"btn_leg"} variant="contained">Leg</Button>
        </div>
    </div>
  )
}

export default App
