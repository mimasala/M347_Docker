import { createTheme, Theme } from "@mui/material";

const darkDefaultTypographyPalette = {
    fontFamily: ["Roboto Mono", "monospace"].join(","),
    fontSize: 14,
    fontWeightLight: 300,
    fontWeightRegular: 400,
    fontWeightMedium: 500,
    fontWeightBold: 700,
    h1: {
        fontSize: "2.5rem",
        fontWeight: 700,
        lineHeight: 1.2,
    },
};
const defaultTransitionSettings = {
    duration: {
        shortest: 150,
        shorter: 200,
        short: 250,
        // most basic recommended timing
        standard: 300,
        // this is to be used in complex animations
        complex: 375,
        // recommended when something is entering screen
        enteringScreen: 225,
        // recommended when something is leaving screen
        leavingScreen: 195,
    },
    easing: {
        // This is the most common easing curve.
        easeInOut: "cubic-bezier(0.4, 0, 0.2, 1)",
        // Objects enter the screen at full velocity from off-screen and
        // slowly decelerate to a resting point.
        easeOut: "cubic-bezier(0.0, 0, 0.2, 1)",
        // Objects leave the screen at full velocity. They do not decelerate when off-screen.
        easeIn: "cubic-bezier(0.4, 0, 1, 1)",
        // The sharp curve is used by objects that may return to the screen at any time.
        sharp: "cubic-bezier(0.4, 0, 0.6, 1)",
    },
};
const defaultOverrides = {
    MuiCssBaseline: {
        '@global': {
            body: {
                transition: 'all 0.3s linear',
            },
        },
    },
}
export const darkTheme: Theme = createTheme({
    palette: {
        primary: { main: "#fff" },
        secondary: { main: "#fff" },
        mode: "dark",
    },
    typography: darkDefaultTypographyPalette,
    transitions: defaultTransitionSettings,
});