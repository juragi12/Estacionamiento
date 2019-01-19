import Vue from 'vue'

export default class WebService {

    getSingleInstance(path) {
        console.log('This is path ' + path);
        console.log('This is data ');

        return path;
    }

    static get (path) {
      return 'hola';
    }


}
