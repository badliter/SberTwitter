const path = require("path");

const HtmlWebpackPlugin = require("html-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackTemplate = require("html-webpack-template");

module.exports = {
    entry: "./src/index.js",
    plugins: [
        new CleanWebpackPlugin(),
        new HtmlWebpackPlugin({
            inject: false,
            template: HtmlWebpackTemplate,
            title: "SberTwitter",
            bodyHtmlSnippet: "<div id=\"root\"></div>",
            lang: "ru",
            links: [
                {
                    href: "https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900",
                    rel: "stylesheet",
                },
            ],
        }),
        new MiniCssExtractPlugin({
            filename: "[name].css",
        }),
    ],
    output: {
        filename: "[name].bundle.js",
        path: path.resolve(__dirname, "dist"),
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader",
                    options: {
                        presets: ["@babel/preset-react"],
                    },
                },
            },
            {
                test: /\.scss$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    "css-loader",
                    "sass-loader",
                ],
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: [
                    "file-loader",
                ],
            },
            {
                test: /\.(woff|woff2|eot|ttf|otf)$/,
                use: [
                    "file-loader",
                ],
            },
            {
                test: /\.(csv|tsv)$/,
                use: [
                    "csv-loader",
                ],
            },
        ],
    },
};
