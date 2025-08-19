//consumer

import { Observable, Observer, Subscription } from "rxjs";
import { DataStorageService } from "./storage";

const storeService = DataStorageService.create();

const obs: Observable<number> = storeService.storeObservable

const numObserver: Observer<number> = {
    next: (data) => { console.log('received: ' + data); },
    error: (e) => { console.log(e.message); },
    complete: () => { console.log('other task...'); }
}

const sub: Subscription = obs.subscribe(numObserver)

setTimeout(
    () => sub.unsubscribe(),
    10000
)

//publisher
const publisherStore = DataStorageService.create();

let value = 1
setInterval(
    () => {
        console.log('publishing ' + value);
        publisherStore.publish(value)
        value++
    },
    1000
)
