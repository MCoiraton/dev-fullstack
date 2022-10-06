import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterlistComponent } from './centerlist.component';

describe('CenterlistComponent', () => {
  let component: CenterlistComponent;
  let fixture: ComponentFixture<CenterlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
