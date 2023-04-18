import { useState } from 'react'
import './index.css'
import {Button} from "@mui/material";


function Home() {
    const [count, setCount] = useState(0)

    return (
        <div className="App">
            <div id={"start_div_container"}>
                <a id={"start_workout_link"} href="/app">
                    <Button id={"btn_start_workout"} variant="contained">Start Workout</Button>
                </a>
            </div>
            <div id={"workout_div_container"}>
                <div id={"history_container"}>
                    <Button id={"btn_history"} variant="contained">History</Button>
                </div>
                <div id={"workout_container"}>
                    <a id={"workout_link"} href="/app">
                        <Button id={"btn_workout"} variant="contained">Workout</Button>
                    </a>
                </div>
            </div>
        </div>
    )
}

export default Home
