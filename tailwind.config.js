module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      dropShadow: {
        purple300: "0 0px 4px #d8b4fe",
        "4xl": [
          "0 35px 35px rgba(0, 0, 0, 0.25)",
          "0 45px 65px rgba(0, 0, 0, 0.15)",
        ],
      },
    },
  },
  plugins: [],
  // purge: {
  //   enabled: guessProductionMode(),
  //   content: ["<path/to/project/**/*.{html, ts, jsx, etc}>"],
  // },
};
