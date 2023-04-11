import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Button } from '@mui/material'

function App() {

  return (
    <div className="App">
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
