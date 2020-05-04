import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionRecordComponent } from './transaction-record.component';

describe('TransactionRecordComponent', () => {
  let component: TransactionRecordComponent;
  let fixture: ComponentFixture<TransactionRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransactionRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
