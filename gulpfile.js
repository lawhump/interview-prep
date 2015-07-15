// Include gulp
var gulp = require('gulp'); 

// Include Our Plugins
var sass = require('gulp-sass');
var minifyCss = require('gulp-minify-css');
var jade = require('gulp-jade');

// 
gulp.task('templates', function() {
    var YOUR_LOCALS = {};

    gulp.src('./notes/templates/*.jade')
    .pipe(jade({
        locals: YOUR_LOCALS
    }))
    .pipe(gulp.dest('./notes/dist/'));
});

// Compile Our Sass
gulp.task('sass', function() {
    return gulp.src('notes/scss/*.scss')
        .pipe(sass())
        .pipe(gulp.dest('notes/dist/css'));
});

// Minify CSS
gulp.task('minify', function() {
    return gulp.src('notes/css/*.css')
    .pipe(minifyCss({compatibility: 'ie8'}))
    .pipe(gulp.dest('notes/dist/css'));
});

// Watch Files For Changes
gulp.task('watch', function() {
    gulp.watch('notes/scss/*.scss', ['sass', 'minify']);
    gulp.watch('notes/templates/index.jade', ['templates']);
});

// Default Task
// gulp.task('default', ['lint', 'sass', 'styles', 'watch']);
gulp.task('default', ['sass', 'minify', 'templates', 'watch']);