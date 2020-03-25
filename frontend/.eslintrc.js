module.exports = {
    env: {
        browser: true,
        es6: true,
    },
    extends: [
        "plugin:react/recommended",
        "airbnb",
    ],
    globals: {
        Atomics: "readonly",
        SharedArrayBuffer: "readonly",
    },
    parserOptions: {
        ecmaFeatures: {
            jsx: true,
        },
        ecmaVersion: 2018,
        sourceType: "module",
    },
    plugins: [
        "react",
    ],
    rules: {
        "react/jsx-filename-extension": [
            1,
            {
                "extensions": [
                    ".js",
                    ".jsx"
                ]
            }
        ],
        "indent": [
            "error",
            4
        ],
        "react/jsx-indent": [
            "error",
            4
        ],
        "react/jsx-indent-props": [
            "error",
            4
        ],
        "quotes": [
            "error",
            "double"
        ],
    },
};
