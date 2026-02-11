// ===== DOM Loaded =====
document.addEventListener("DOMContentLoaded", function() {

    // Update habit completion percentage
    const habitRows = document.querySelectorAll("table tr.habit-row");
    
    habitRows.forEach(row => {
        const checkboxes = row.querySelectorAll("input[type='checkbox']");
        const progressBar = row.querySelector(".progress-bar");

        checkboxes.forEach(checkbox => {
            checkbox.addEventListener("change", () => {
                let completed = 0;
                checkboxes.forEach(cb => { if(cb.checked) completed++; });
                const percentage = (completed / checkboxes.length) * 100;
                if(progressBar) progressBar.style.width = percentage + "%";
                if(progressBar) progressBar.innerText = Math.round(percentage) + "%";
            });
        });
    });

    // Optional: Add new habit dynamically
    const addHabitBtn = document.getElementById("addHabitBtn");
    if(addHabitBtn) {
        addHabitBtn.addEventListener("click", () => {
            const habitName = prompt("Enter Habit Name:");
            const monthlyGoal = prompt("Enter Monthly Goal:");
            if(habitName && monthlyGoal) {
                alert("Habit added: " + habitName + " | Goal: " + monthlyGoal);
                // TODO: Integrate with Servlet/AJAX to save in DB
            }
        });
    }
});
