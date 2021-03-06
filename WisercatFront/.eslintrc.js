module.exports = {
    "parser": "@babel/eslint-parser",
    "parserOptions": {
        "ecmaFeatures": {
            "jsx": true
        }
    },
    "env": {
        "browser": true,
        "es6": true
    },
    "ignorePatterns": ["public/"],
    "plugins": ["import", "react"],
    "extends": [
        "eslint:recommended",
        "google",
        "plugin:import/errors",
        "plugin:import/warnings",
        "plugin:react/recommended"
    ],
    "rules": {
        "max-len": ["error", 120],
        "require-jsdoc": "off",
        "comma-dangle": "off",
        "no-console": 2,
        "react/react-in-jsx-scope": "off"
    },
    "settings": {
        "react": {
            "version": "detect"
        }
    }
};

