import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditserverComponent } from './editserver.component';

describe('EditserverComponent', () => {
  let component: EditserverComponent;
  let fixture: ComponentFixture<EditserverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditserverComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditserverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
