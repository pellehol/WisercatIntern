import resolve from '@rollup/plugin-node-resolve';
import babel from '@rollup/plugin-babel';
import serve from 'rollup-plugin-serve';
import livereload from 'rollup-plugin-livereload';
import scss from 'rollup-plugin-scss';
import copy from 'rollup-plugin-copy';
import commonjs from '@rollup/plugin-commonjs';
import replace from '@rollup/plugin-replace';

const watching = process.env.ROLLUP_WATCH === 'true';
const open = process.env.START_BROWSER === 'true';
const environment = (watching && 'development') || 'production';

export default {
  input: 'src/index.js',
  output: {
    file: 'build/app.js',
    format: 'iife',
    sourcemap: true,
  },
  plugins: [
    resolve({browser: true}),
    commonjs({
      include: 'node_modules/**',
    }),
    copy({targets: [{src: 'public/index.html', dest: 'build/'}]}),
    replace({
      'process.env.NODE_ENV': JSON.stringify(environment),
      'preventAssignment': true,
    }),
    babel({babelHelpers: 'bundled'}),
    scss({sourceMap: true}),
  ]
      .concat(watching ?
            [
              serve({
                contentBase: ['build'],
                port: 1001,
                verbose: true,
                open
              }),
              livereload()
            ] : [])
};
