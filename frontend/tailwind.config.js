module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      dropShadow: {
        purple300: "0 0 4px #d8b4fe",
        teal300: "0 0 4px #5eead4",
        red600: "0 0 4px #dc2626",
        emerald400: "0 0 4px #34d399",
        green500: "0 0 4px #22c55e",
        slate400: "0 0 4px #94a3b8",
      },
    },
  },
  plugins: [],
  // purge: {
  //   enabled: guessProductionMode(),
  //   content: ["<path/to/project/**/*.{html, ts, jsx, etc}>"],
  // },
};
