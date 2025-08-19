import { BehaviorSubject } from "rxjs";
export class DataStorageService {
    private static service: DataStorageService;

    private store = new BehaviorSubject<number>(0)
    storeObservable = this.store.asObservable()

    publish(value: number): void {
        this.store.next(value)
    }

    private constructor() {
        console.log('created...');
    }
    static create(): DataStorageService {
        if (!this.service)
            this.service = new DataStorageService()

        return this.service;
    }
}