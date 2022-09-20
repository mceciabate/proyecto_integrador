import React from "react";
import DatePicker from "react-datepicker";
import { CustomHeader } from "../pages/reserve/ReserveStyles";
import "../pages/reserve/calendarStyles.css";


const Calendar = ({ startDate, endDate, setStartDate, setEndDate }) => {
  const handleChange = (dates) => {
    const [start, end] = dates;
    setStartDate(start);
    setEndDate(end);
  };
  let invalidDates = []
  invalidDates = JSON.parse(window.localStorage.getItem('Dates'))
  invalidDates.pop()
  let date1 = new Date(invalidDates[0])
  let date2 = new Date(invalidDates[1])
  let date3 = new Date(invalidDates[2])
  let date4 = new Date(invalidDates[3])
  let date5 = new Date(invalidDates[4])
  let date6 = new Date(invalidDates[5])
  let date7 = new Date(invalidDates[6])
  let date8 = new Date(invalidDates[7])
  let datearray = [date1, date2, date3, date4, date5, date6, date7, date8]
  console.log(datearray)
  return (
    <CustomHeader className="hola">
      <DatePicker
        selected={startDate}
        onChange={handleChange}
        monthsShown={2}
        inline={true}
        excludeDates={datearray}
        renderCustomHeader={({
          monthDate,
          customHeaderCount,
          decreaseMonth,
          increaseMonth,
        }) => (
          <div>
            <button
              aria-label="Previous Month"
              className={
                "react-datepicker__navigation react-datepicker__navigation--previous"
              }
              style={customHeaderCount === 1 ? { visibility: "hidden" } : null}
              onClick={decreaseMonth}
            >
              <span
                className={
                  "react-datepicker__navigation-icon react-datepicker__navigation-icon--previous"
                }
              >
                {"<"}
              </span>
            </button>
            <span className="react-datepicker__current-month">
              {monthDate.toLocaleString("en-US", {
                month: "long",
                year: "numeric",
              })}
            </span>
            <button
              aria-label="Next Month"
              className={
                "react-datepicker__navigation react-datepicker__navigation--next"
              }
              style={customHeaderCount === 0 ? { visibility: "hidden" } : null}
              onClick={increaseMonth}
            >
              <span
                className={
                  "react-datepicker__navigation-icon react-datepicker__navigation-icon--next"
                }
              >
                {">"}
              </span>
            </button>
          </div>
        )}
        selectsRange
        startDate={startDate}
        showPreviousMonths={false}
        endDate={endDate}
        dateFormat="yyyy-MM-dd"
      />
    </CustomHeader>
  );
};

export default Calendar;
