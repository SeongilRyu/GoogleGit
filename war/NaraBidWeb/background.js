/**
 * Listens for the app launching then creates the window
 *
 * @see http://developer.chrome.com/apps/app.window.html
 */

var dbName = 'narabidweb-db';
//chrome.app.runtime.onLaunched.addListener(function() {
chrome.app.runtime.onLaunched.addListener(launch);

function launch() {
  chrome.app.window.create('index.html', {
    id: 'main',
    bounds: { width: 640, height: 600 }
  });
}
//});

