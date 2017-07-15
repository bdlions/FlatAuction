var webpack = require('webpack');
module.exports = {
    entry: {
        non_member: "./non-member-template.js",
        member: "./member-template.js"
    },
    output: {
        path: __dirname,
        filename: "./[name]_bundle.js"
    },
    module: {
        loaders: [
            {test: /\.css$/, loader: "style!css"}
        ]
    },
    plugins: [
        // minify output
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                sequences: true,
                dead_code: true,
                conditionals: true,
                booleans: true,
                unused: true,
                if_return: true,
                join_vars: true,
                drop_console: true
            },
            sourceMap: false,
            output: {comments: false}
        })
    ]
};
