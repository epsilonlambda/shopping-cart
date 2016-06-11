module.exports = {
    entry: './src/main/js/index.js',
    output: {
        path: './build',
        filename: 'bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react'],
		    plugins: ['transform-class-properties']
                }
            }
        ]
    }
};
